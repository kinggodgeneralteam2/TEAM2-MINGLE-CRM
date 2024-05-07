<template>
  <div>
    <h1>고객 관리</h1>
    <CustomerEdit />
  </div>
</template>

<script>
import CustomerEdit from "@/components/CustomerEdit.vue";

export default {
  components: {
    CustomerEdit,
  },
};
</script>

<style scoped>
h1 {
  text-align: center;
  margin-bottom: 20px;
}
</style>
