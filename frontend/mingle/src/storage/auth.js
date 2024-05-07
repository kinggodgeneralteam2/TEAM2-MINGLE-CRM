import { defineStore } from 'pinia';
// import { ref } from 'vue';

export const useAuthStore = defineStore({
    id: 'auth',
    state: () => ({
        accessToken: '',
        refreshToken: '',
    }),
    actions: {
        setTokens(accessToken, refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;
        },
        clearTokens() {
            this.accessToken = '';
            this.refreshToken = '';
        },
    },
});