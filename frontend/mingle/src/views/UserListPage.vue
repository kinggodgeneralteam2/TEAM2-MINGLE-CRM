<template>
  <div>
    <h1>사용자 관리</h1>
    <UserList />
  </div>
</template>

<script>
import UserList from "@/components/UserList.vue";

export default {
  components: {
    UserList
  }
};
</script>

<style scoped>
h1 {
  text-align: center;
  margin-bottom: 20px;
}
</style>
