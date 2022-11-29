<template>
  <v-row>
    <div>
      <v-col></v-col>
      <h2>Recomend course</h2>
      <v-col style="height: 10px"></v-col>
      <v-row>
        <!-- <v-card class="mr-9 mx-auto" max-width="400">
          <v-img
            src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
            height="200px"
          ></v-img>

          <v-card-title> Top western road trips </v-card-title>

          <v-card-subtitle> 1,000 miles of wonder </v-card-subtitle>
          <v-spancer></v-spancer>
          <v-btn href="/detail" color="white" text> Get </v-btn>
        </v-card> -->

        <v-layout wrap>
        <v-flex lg3 md4 sm12 xs6 v-for="(b, idx) in this.book" :key="idx" :items="book">
          <v-card class="card">
            <div class="img">
              <img style="" class="text-center" :src="b.image" />
            </div>
            <v-card-title>{{ b.title }}</v-card-title>
            <v-card-text>
              <div>ID : {{ b.id }}</div>
              <div>Book : {{ b.description }}</div>
              <div>Author : {{ b.author.name }}</div>
            </v-card-text>
            <v-btn outlined rounded text class="cen mb-5" @click="onOpenBook(b)">
              BOOKING
            </v-btn>
            <v-dialog v-model="dialog" persistent max-width="600px">
              <v-card>
                <v-card-title>
                  <span class="text-h5">Edit Date</span>
                </v-card-title>
                <v-card-text>
                  <v-container>
                    <v-row>
                      <v-text-field v-model.trim="form.date" label="Date"></v-text-field>
                    </v-row>
                  </v-container>
                </v-card-text>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="dialog = false">
                    Close
                  </v-btn>
                  <v-btn color="blue darken-1" text @click="onBooking()">
                    Save
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-card>
        </v-flex>
      </v-layout>
      
      </v-row>

      <v-col></v-col>
      <h2>Unity</h2>
      <v-col style="height: 10px"></v-col>
      <v-row>
        <v-card class="mr-9 mx-auto" max-width="400">
          <v-img
            src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
            height="200px"
          ></v-img>

          <v-card-title> Top western road trips </v-card-title>

          <v-card-subtitle> 1,000 miles of wonder </v-card-subtitle>
          <v-spancer></v-spancer>
          <v-btn color="white" text> Get </v-btn>
        </v-card>

        <v-card class="mr-9 mx-auto" max-width="400">
          <v-img
            src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
            height="200px"
          ></v-img>

          <v-card-title> Top western road trips </v-card-title>

          <v-card-subtitle> 1,000 miles of wonder </v-card-subtitle>
          <v-spancer></v-spancer>
          <v-btn color="white" text> Get </v-btn>
        </v-card>

        <v-card class="mr-9 mx-auto" max-width="400">
          <v-img
            src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
            height="200px"
          ></v-img>

          <v-card-title> Top western road trips </v-card-title>

          <v-card-subtitle> 1,000 miles of wonder </v-card-subtitle>
          <v-spancer></v-spancer>
          <v-btn color="white" text> Get </v-btn>
        </v-card>

        <v-card class="mr-9 mx-auto" max-width="400">
          <v-img
            src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
            height="200px"
          ></v-img>

          <v-card-title> Top western road trips </v-card-title>

          <v-card-subtitle> 1,000 miles of wonder </v-card-subtitle>
          <v-spancer></v-spancer>
          <v-btn color="white" text> Get </v-btn>
        </v-card>
      </v-row>
    </div>
  </v-row>
</template>

<script>
export default {
  data: () => ({
    show: false,
  }),
};
</script>