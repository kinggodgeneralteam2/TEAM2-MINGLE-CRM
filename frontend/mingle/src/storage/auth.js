import { defineStore } from 'pinia';
import { jwtDecode } from "jwt-decode";
// import { ref } from 'vue';

export const useAuthStore = defineStore({
    id: 'auth',
    state: () => ({
        accessToken: '',
        refreshToken: '',
        userId: '', // 사용자 ID 추가
    }),
    actions: {
        setTokens(accessToken, refreshToken) {
            this.accessToken = accessToken;
            this.refreshToken = refreshToken;

            // 토큰이 설정될 때마다 사용자 ID를 업데이트합니다.
            this.updateUserId();
        },
        clearTokens() {
            this.accessToken = '';
            this.refreshToken = '';
            this.userId = ''; // 사용자 ID 초기화
        },
        updateUserId() {
            if (this.accessToken) {
                const payload = jwtDecode(this.accessToken);
                const userId = payload.userId;
                // Pinia Store에 사용자 ID 저장
                // 이렇게 하면 나중에 필요할 때 사용자 ID를 얻을 수 있습니다.
                this.userId = userId;
            }
        },
    },
});