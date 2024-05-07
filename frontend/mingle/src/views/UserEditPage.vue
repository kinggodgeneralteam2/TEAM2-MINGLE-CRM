<template>
  <div>
    <h1>사용자 정보 수정 페이지</h1>
    <!-- UserUpdate 컴포넌트를 렌더링하고, 동적 매개변수인 id를 props로 전달합니다. -->
    <UserUpdate :userId="userId" />
  </div>
</template>

<script>
import UserUpdate from '@/components/UserUpdate.vue';

export default {
  components: {
    UserUpdate
  },
  data() {
    return {
      userId: null // 사용자의 ID를 저장할 변수
    };
  },
  created() {
    // Vue Router에서 동적 매개변수로 전달된 사용자 ID를 가져옵니다.
    this.userId = this.$route.params.id;
  }
};
</script>
