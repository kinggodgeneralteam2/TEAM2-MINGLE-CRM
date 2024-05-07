<template>
  <div class="user-list-container">
    <div class="user-list">
      <h2>유저 목록</h2>
      <ul v-if="users.length > 0" class="user-items">
        <li v-for="user in users" :key="user.id" class="user-item">
          <div class="user-info">
            <span class="user-name">{{ user.name }}</span>
            <span class="user-email">({{ user.email }})</span>
          </div>
        </li>
      </ul>
      <p v-else class="empty-message">유저가 없습니다.</p>
      <p v-if="errorMessage" class="error-message">{{ errorMessage }}</p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      users: [],
      errorMessage: ''
    };
  },
  created() {
    this.fetchUsers();
  },
  methods: {
    async fetchUsers() {
      try {
        const response = await axios.get('http://localhost:3000/users');
        this.users = response.data;
        this.errorMessage = '';
      } catch (error) {
        console.error('유저 목록을 불러오는 중 에러 발생:', error);
        this.errorMessage = '유저 목록을 불러오는 중 에러가 발생했습니다.';
      }
    }
  }
};
</script>

<style scoped>
.user-list-container {
  max-width: 600px;
  margin: 0 auto;
}

.user-list {
  background-color: #f5f5f5;
  border-radius: 10px;
  padding: 20px;
}

.user-items {
  list-style-type: none;
  padding: 0;
}

.user-item {
  background-color: #ffffff;
  padding: 15px;
  border-radius: 5px;
  margin-bottom: 15px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.user-info {
  display: flex;
  justify-content: space-between;
}

.user-name {
  font-weight: bold;
}

.empty-message, .error-message {
  margin-top: 20px;
  text-align: center;
  color: #555555;
}

.error-message {
  color: red;
}
</style>
