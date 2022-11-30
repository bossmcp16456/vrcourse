<template>
    <v-row>
        <div>
            <v-col></v-col>
            <v-col style="height: 10px"></v-col>
            <v-card class="mr-9 mx-auto" max-width="800">
                <v-img src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg" height="200px"></v-img>
    
                <v-card-title> {{info.name}} </v-card-title>
                <v-card-subtitle> </v-card-subtitle>
                <v-card-subtitle> {{info.price}} baht </v-card-subtitle>
    
            </v-card>
    
            <h2 class="mt-10">Date of study :</h2>
    
            <v-row>
                <v-col cols="12" lg="6">
                    <v-menu v-model="menu2" :close-on-content-click="false" max-width="290">
                        <template v-slot:activator="{ on, attrs }">
                            <v-text-field :value="computedDateFormattedDatefns" clearable label="Select D/M/Y." readonly v-bind="attrs" v-on="on" @click:clear="date = null"></v-text-field>
                        </template>
                        <v-date-picker v-model="date" @change="menu2 = false"></v-date-picker>
                    </v-menu>
                    <v-btn @click="bookna()" >
                        Buy
                    </v-btn>
                </v-col>
            </v-row>
        </div>
    </v-row>
    </template>
    
    <script>
    import Axios from "axios";
    import {
        format,
        parseISO
    } from "date-fns";
    
    export default {
    
        data: () => ({
    
            date: format(parseISO(new Date().toISOString()), "yyyy-MM-dd"),
            menu2: false,
            info: [],
            form: {
                course: "4",
                user: "1",
                date: "",
            }
        }),
    
        computed: {
            computedDateFormattedDatefns() {
                return this.date ? format(parseISO(this.date), "EEEE, MMMM do yyyy") : "".toString;
    
            },
    
        },
        created() {
    
            Axios.get('/api/getCourseById/4').then((res) => {
                this.info = res.data
            })
    
        },
        methods: {
            test() {
                console.log(this.info)
            },
            bookna() {
                this.form.date = this.date.toString();
                Axios.post('/api/addBookcourse', {
                    datetime:this.form.date,
                    course:{id:this.form.course},
                    user:{id:this.form.user}
                }).then((res) => {
                    alert("Add course successful !");
                })
            }
        }
    
    };
    </script>
    