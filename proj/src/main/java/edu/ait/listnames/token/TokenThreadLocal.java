package edu.ait.listnames.token;

public class TokenThreadLocal {
    private static ThreadLocal<TokenDto> threadLocal = new ThreadLocal<>();

    /**
     * 保存用户  save user
     *
     * @param t
     */
    public static void put(TokenDto t) {
        threadLocal.set(t);
    }

    /**
     * 获取用户  get user
     *
     * @return
     */
    public static TokenDto get() {
        return threadLocal.get();
    }

    /**
     * 清空 remove
     */
    public static void remove() {
        threadLocal.remove();
    }

    /**
     * 获取用户Id  getUserId
     *
     * @return
     */
    public static Long getUserId() {
        return threadLocal.get() != null ? Long.valueOf(threadLocal.get().getUserId()) : null;
    }
}
