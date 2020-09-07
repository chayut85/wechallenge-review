<template>
  <div>
  <input placeholder="Enter review id or text" v-model="userInput" >
    <span v-for="(searchOption) in searchOptionList" :key="searchOption.id">
      <input type="radio" :value="searchOption.id" v-model="picked2" @change="onChange($event)"> {{searchOption.optionID}}
    </span>
    <button v-on:click="getReview">Search</button>
  <div>
    <ul id="example-1">
      <div v-for="review in reviewItems" :key="review.id">
      <label>
        {{ review.review }}
      </label>
        <textarea v-if="review.edit" v-model="review.review"></textarea>
        <button v-on:click="editReview(review.id)"> Edit </button>
        <button type="submit" v-on:click="saveReview(review.id)" > Save </button>
      </div>
    </ul>
  </div>
  </div>



</template>

<script>

import axios from 'axios';

export default {
  name: 'ReviewList',
  data: () => ({
    userInput: '',
    picked2: 1,
    selectOption: 1,
    searchOptionList:[
      {optionID: "Search By ID", id: 1},
      {optionID: "Search By Text", id: 2}
    ],


    reviewItems: [
      { review: 'Sushi tastes good', id: 1, edit: false},
      { review: 'Ramen is bad' , id: 2, edit: false},
      { review: 'Sushi is bad' , id: 3, edit: false},
      { review: 'Ramen is good' , id: 4, edit: false},
      { review: 'Tempura is ok' , id: 5, edit: false},
      { review: 'Tempura is bad' , id: 6, edit: false},
      { review: 'Tempura is good' , id: 7, edit: false}
    ]
  }),
  methods: {
    editReview(id){
      this.reviewItems.find(itm => itm.id===id).edit = true;

    },

    onChange(event) {
      this.selectOption = event.target.value;
    },

    saveReview(id){
      const item = this.reviewItems.find(itm => itm.id===id);
      var self = this;

      axios({
        method: 'put',
        url: 'http://localhost:8080/reviews/' + id,
        headers: {},
        data: {
          review: item.review
        }
      }).then(function(response){
        item.edit = false;
        // self.reviewItems = response;
        self.reviewItems.push({review: response.data});
      }, function(error){
        console.log(error.statusText);
      });

    },

    getReview() {
      var self = this;
      var link;
          if(Number(this.selectOption)===1){
            link = 'http://localhost:8080/reviews/' + this.userInput;
      }
          else if (Number(this.selectOption)===2) {
            link = 'http://localhost:8080/reviews?query=' + this.userInput;

      }

      axios.get(link).then(function(response){
        // self.reviewItems = response;
        self.reviewItems.push({review: response.data});
      }, function(error){
        console.log(error.statusText);
      });

    }

  }

}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
