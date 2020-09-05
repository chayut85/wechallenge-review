<template>
  <div>
  <input v-text="search_review" placeholder="enter review id or text">
  <input type="radio" id="search_id" value="One" v-model="picked">
  <label for="search_id">Search by id</label>
  <input type="radio" id="search_text" value="One" v-model="picked">
  <label for="search_text">Search by text</label>
  <button small color="primary"> Search </button>
  </div>
</template>

<script>
export default {
  name: 'ReviewList'
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
