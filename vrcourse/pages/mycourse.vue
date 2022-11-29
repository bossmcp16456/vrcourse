<template>
  <v-row>
      <div>
          <v-col></v-col>
          <h2>Recomend course</h2>
          <v-col style="height: 10px"></v-col>
          <v-row>

              <v-layout wrap>
                  <v-flex lg3 md4 sm12 xs6 v-for="(b, idx) in this.info" :key="idx" :items="info">
                      <v-card class="card">
                          <div class="img">
                              <img style="" class="text-center" src="https://i.ytimg.com/vi/kH_piLCynto/maxresdefault.jpg" />
                          </div>
                          <v-card-title>{{ b.course.name }}</v-card-title>
                          <v-card-text>
                              <div>Name : {{ b.course.teacher.name }} {{ b.course.teacher.lastname }}</div>
                            
                          </v-card-text>
                          <v-btn outlined rounded text class="cen mb-5" @click="cc(b)">
                              Delete
                          </v-btn>
                      </v-card>
                  </v-flex>
              </v-layout>
  
          </v-row>
  
      </div>
  </v-row>
  </template>
  
  <script>
  import Axios from "axios";
  export default {
  
      data: () => ({
          show: false,
          info: [],
          arrayData: [],
      }),
      created() {
          // this.initialize(),
          // this.getname()
          Axios.get('/api/getAllBookcourses').then((res) => {
              this.info = res.data
          })
          
  
      },
  
      methods: {
          onOpenCourse(data) {
            this.arrayData.push(data);
              this.$router.push({
                  path: "/detail"
              });
          },
          cc(data){
            console.log(data.id);
            Axios.delete('/api/deleteBookcourseById/'+data.id).then((res) => {
              Axios.get('/api/getAllBookcourses').then((res) => {
              this.info = res.data
          })
          })
          }
      }
  };
  </script>
  
  <style scoped>
  
  .cen {
      display: block;
      margin-left: auto;
      margin-right: auto;
  
  }
  
  .card {
      padding: 5px;
      margin: 20px;
      overflow: hidden;
      width: 1000px;
      height: 580px;
  }
  
  img {
      display: block;
      margin-left: auto;
      margin-right: auto;
      width: auto;
      height: 250px;
  }
  
  .center {
      margin: 0;
      position: absolute;
      top: 50%;
      left: 50%;
      -ms-transform: translate(-50%, -50%);
      transform: translate(-50%, -50%);
  }
  </style>
  