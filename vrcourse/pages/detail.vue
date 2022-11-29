<template>
    <v-row>
      <div>
        <v-col></v-col>
        <v-col style="height: 10px"></v-col>
        <v-card class="mr-9 mx-auto" max-width="800">
          <v-img
            src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
            height="200px"
          ></v-img>
  
          <v-card-title> Top western road trips </v-card-title>
  
          <v-card-subtitle> 1,000 miles of wonder </v-card-subtitle>
          <v-spancer></v-spancer>
        </v-card>
        
        <h2 class="mt-10">Date of study :</h2>
  
        <v-row>
          <v-col cols="12" lg="6">
            <v-menu
              v-model="menu2"
              :close-on-content-click="false"
              max-width="290"
            >
              <template v-slot:activator="{ on, attrs }">
                <v-text-field
                  :value="computedDateFormattedDatefns"
                  clearable
                  label="Select D/M/Y."
                  readonly
                  v-bind="attrs"
                  v-on="on"
                  @click:clear="date = null"
                ></v-text-field>
              </template>
              <v-date-picker
                v-model="date"
                @change="menu2 = false"
              ></v-date-picker>
            </v-menu>
            <v-btn>
                Buy
            </v-btn>
          </v-col>
        </v-row>
      </div>
    </v-row>
  </template>
  
  <script>
  import { format, parseISO } from "date-fns";
  
  export default {
    data: () => ({
      // https://github.com/date-fns/date-fns/blob/master/docs/upgradeGuide.md#string-arguments
      date: format(parseISO(new Date().toISOString()), "yyyy-MM-dd"),
      menu2: false,
    }),
  
    computed: {
      computedDateFormattedDatefns() {
        return this.date ? format(parseISO(this.date), "EEEE, MMMM do yyyy") : "";
      },
    },
  };
  </script>