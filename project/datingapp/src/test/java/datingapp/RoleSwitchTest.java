package datingapp;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.project.datingapp.dto.RoleSwitchDTO;
import com.project.datingapp.entity.User;
import com.project.datingapp.repository.UserRepository;
import com.project.datingapp.service.RoleSwitchService;

@SpringBootTest
public class RoleSwitchTest {

    @Autowired
    private RoleSwitchService roleSwitchService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testRoleSwitchServiceExists() {
        assertNotNull(roleSwitchService, "RoleSwitchService should be available");
    }

    @Test
    void testRoleSwitchDTOStructure() {
        RoleSwitchDTO dto = new RoleSwitchDTO();
        dto.setTargetRole("MERCHANT");
        dto.setUsername("testuser");
        dto.setPassword("testpass");

        assertEquals("MERCHANT", dto.getTargetRole());
        assertEquals("testuser", dto.getUsername());
        assertEquals("testpass", dto.getPassword());
    }

    // Note: More comprehensive tests would require setting up test data
    // and mocking the authentication context
}