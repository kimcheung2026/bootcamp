package com.project.datingapp.config;

public class AuthPath {

        // 1. 模組前綴與具體路徑
        public static final String AUTH_PREFIX = "";
        public static final String PAGE_PREFIX = "";
        public static final String MATCH_PREFIX = "/match";
        public static final String MEMBER_PREFIX = "/member";
        public static final String ADMIN_PREFIX = "/admin";
        public static final String MERCHANT_PREFIX = "/merchant";
        public static final String COURSE_PREFIX = "/course";

        // 2. 常用具體路徑
        public static final String LOGIN = "/login";
        public static final String REGISTER = "/register";
        public static final String HOME = "/home";
        public static final String MAIN = "/main";
        public static final String BLIND_BOX = "/blindBoxOpen";
        public static final String MEMBERS_LIST = "/list";
        public static final String MERCHANT_VERIFY = "/merchants/verify";

        // 3. 靜態資源 (解決你目前的報錯)
        public static final String[] STATIC_RESOURCES = {
                        "/css/**",
                        "/js/**",
                        "/images/**",
                        "/favicon.ico",
                        "/uploads/**"
        };

        // 4. 權限配置陣列 (給 SecurityConfig 使用)
        public static final String[] PUBLIC = {
                        "/",
                        LOGIN,
                        REGISTER,
                        HOME,
                        "/forgot-password",
                        "/user/register",
                        "/merchant/register"
        };

        public static final String USER_ONLY = MATCH_PREFIX + "/**";
        public static final String MERCHANT_ONLY = COURSE_PREFIX + "/**"; // 商家專屬路徑
        public static final String ADMIN_ANY = ADMIN_PREFIX + "/**";
        public static final String MEMBERS = MEMBER_PREFIX + "/**";

        // 使用者註冊路徑
        public static final String USER_REGISTER = "/user/register";

        // 商家專用
        public static final String MERCHANT_MAIN = MERCHANT_PREFIX + "/main";
        public static final String MERCHANT_PUBLISH = "/publish";

        // 管理者後台
        public static final String ADMIN_DASHBOARD = ADMIN_PREFIX + "/dashboard"; // /admin/dashboard

        // ===================== 課程模組 =====================
        public static final String COURSE_PUBLISH = "/publish";
        public static final String COURSE_LIST = "/list";

        // 配對相關
        public static final String MATCH_COURSE = "/course";

        // 5. 重導向封裝
        public static final String REDIRECT_ADMIN_VERIFY = "redirect:" + ADMIN_PREFIX + MERCHANT_VERIFY;
        public static final String REDIRECT_LOGIN = "redirect:" + LOGIN;
        public static final String REDIRECT_REGISTER = "redirect:" + REGISTER;
        public static final String REDIRECT_COURSE_PUBLISH = "redirect:" + COURSE_PREFIX + COURSE_PUBLISH;
        public static final String REDIRECT_COURSE_LIST = "redirect:" + COURSE_PREFIX + COURSE_LIST;

        // 密碼重設相關
        public static final String FORGOT_PASSWORD = "/forgot-password";
        public static final String REDIRECT_FORGOT_PASSWORD = "redirect:" + FORGOT_PASSWORD;

        // 角色切換相關
        public static final String ROLE_SWITCH = "/role/switch";
        public static final String ROLE_CURRENT = "/role/current";
        public static final String ROLE_DASHBOARD = "/role/dashboard";
}
