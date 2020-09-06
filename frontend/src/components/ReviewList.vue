<template>
  <div>
  <input v-text="search_review" placeholder="Enter review id or text">
    <span v-for="(searchOption) in searchOptionList" :key="searchOption.id">
      <input type="radio" :value="searchOption.id" v-model="picked2">{{searchOption.optionID}}
    </span>
    <button>Search</button>
  <div>
    <ul id="example-1">
      <label v-for="review in reviewItems" :key="review.id">
        {{ review.review }}<br>
      </label>
    </ul>
  </div>
  </div>



</template>

<script>

export default {
  name: 'ReviewList',
  data: () => ({
    picked2: 1,
    searchOptionList:[
      {optionID: "Search By ID", id: 1},
      {optionID: "Search By Text", id: 2}
    ],
    reviewItems: [
      { review: 'Review by Wongnai' },
      { review: 'Review by Wongnok' }
    ]
  })

}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
