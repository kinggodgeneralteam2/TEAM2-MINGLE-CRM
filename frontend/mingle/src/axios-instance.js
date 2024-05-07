import axios from 'axios';

// 전역 Axios 인스턴스 생성
const instance = axios.create({
    baseURL: 'http://example.com/api', // 기본 URL 설정
    timeout: 5000, // 타임아웃 설정
});

// 요청 전 인터셉터 설정
instance.interceptors.request.use(
    config => {
        const accessToken = localStorage.getItem('accessToken');
        if (accessToken) {
            config.headers.Authorization = `Bearer ${accessToken}`; // 헤더에 토큰 추가
        }
        return config;
    },
    error => {
        return Promise.reject(error);
    }
);

export default instance; // 인스턴스를 export하여 모든 컴포넌트에서 사용할 수 있게 함
