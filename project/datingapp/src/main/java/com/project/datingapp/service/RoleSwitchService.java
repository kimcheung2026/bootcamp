package com.project.datingapp.service;

import com.project.datingapp.dto.RoleSwitchDTO;
import com.project.datingapp.entity.Merchant;
import com.project.datingapp.entity.User;
import com.project.datingapp.exception.ErrorCode;
import com.project.datingapp.exception.UserServiceException;
import com.project.datingapp.repository.MerchantRepository;
import com.project.datingapp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RoleSwitchService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MerchantRepository merchantRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Switch between USER and MERCHANT roles
     */
    @Transactional
    public String switchRole(RoleSwitchDTO dto) {
        // Verify the user exists and password is correct
        User user = userRepository.findByUsername(dto.getUsername())
                .orElseThrow(() -> new UserServiceException(ErrorCode.USER_NOT_FOUND, "User not found"));

        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new UserServiceException(ErrorCode.AUTH_FAILED, "Invalid password");
        }

        String targetRole = dto.getTargetRole().toUpperCase();

        if (targetRole.equals("MERCHANT")) {
            return switchToMerchant(user);
        } else if (targetRole.equals("USER")) {
            return switchToUser(user);
        } else {
            throw new UserServiceException(ErrorCode.INVALID_ROLE, "Invalid target role: " + targetRole);
        }
    }

    /**
     * Switch from USER to MERCHANT role
     */
    private String switchToMerchant(User user) {
        // Check if user already has merchant role
        if (user.getRole().equals("ROLE_MERCHANT")) {
            return "User is already a merchant";
        }

        // Check if user has a linked merchant account
        if (user.getLinkedMerchantId() != null) {
            Merchant merchant = merchantRepository.findById(user.getLinkedMerchantId())
                    .orElseThrow(
                            () -> new UserServiceException(ErrorCode.MERCHANT_NOT_FOUND, "Linked merchant not found"));

            if (!merchant.isVerified()) {
                throw new UserServiceException(ErrorCode.MERCHANT_NOT_VERIFIED, "Merchant account is not verified");
            }

            // Update user role
            user.setRole("ROLE_MERCHANT");
            userRepository.save(user);
            return "Switched to merchant role successfully";
        }

        // User doesn't have a merchant account, check if they want to create one
        throw new UserServiceException(ErrorCode.MERCHANT_NOT_FOUND,
                "No merchant account linked. Please register as a merchant first.");
    }

    /**
     * Switch from MERCHANT to USER role
     */
    private String switchToUser(User user) {
        // Check if user already has user role
        if (user.getRole().equals("ROLE_USER")) {
            return "User is already in user role";
        }

        // Switch back to user role
        user.setRole("ROLE_USER");
        userRepository.save(user);
        return "Switched to user role successfully";
    }

    /**
     * Link a merchant account to a user account
     */
    @Transactional
    public void linkMerchantToUser(Long userId, Long merchantId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserServiceException(ErrorCode.USER_NOT_FOUND, "User not found"));

        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new UserServiceException(ErrorCode.MERCHANT_NOT_FOUND, "Merchant not found"));

        // Check if merchant is verified
        if (!merchant.isVerified()) {
            throw new UserServiceException(ErrorCode.MERCHANT_NOT_VERIFIED, "Merchant account is not verified");
        }

        // Link them together
        user.setLinkedMerchantId(merchantId);
        merchant.setLinkedUserId(userId);

        userRepository.save(user);
        merchantRepository.save(merchant);
    }

    /**
     * Get current role of a user
     */
    public String getCurrentRole(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserServiceException(ErrorCode.USER_NOT_FOUND, "User not found"));

        return user.getRole();
    }
}