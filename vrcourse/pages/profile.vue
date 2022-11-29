<template>
<div id="app">
    <div class="d-flex justify-center ma-4">
        <v-img max-height="250" max-width="250" src="https://steamuserimages-a.akamaihd.net/ugc/1698402494138384338/0498B0E43EE31061B164EA96BAE2F2F9E13F4A23/?imw=512&&ima=fit&impolicy=Letterbox&imcolor=%23000000&letterbox=false"></v-img>
    </div>
    <v-app id="inspire">
        <v-form>
            <v-container>

                <v-row class="row">
                    <v-col cols="12" sm="6">
                        <v-text-field label="First Name" filled v-model="form.name"></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="6">
                        <v-text-field label="Last Name" filled v-model="form.lastname"></v-text-field>
                    </v-col>
                </v-row>
                <v-row class="row">
                    <v-col cols="12" sm="6">
                        <v-text-field label="Email" filled v-model="form.email"></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="6">
                        <v-text-field label="Password" filled password v-model="form.password"></v-text-field>
                    </v-col>
                </v-row>
                <v-row class="row">
                    <v-col cols="12" sm="6">
                        <v-text-field label="Gender" filled v-model="form.gender"></v-text-field>
                    </v-col>

                    <v-col cols="12" sm="6">
                        <v-text-field label="Telephone" filled v-model="form.telephone"></v-text-field>
                    </v-col>
                </v-row>

                <v-row class="justify-center">
                    <v-btn class="saveprofile" color="green" dark on-click @click="onSave()">
                        Save
                    </v-btn>
                    
                </v-row>
            </v-container>
        </v-form>
    </v-app>
</div>
</template>

<script>
import Axios from "axios";
export default {
    data: () => ({
        form: {
            name: "",
            lastname: "",
            password: "",
            email: "",
            gender: "",
            telephone: "",
        }
    }),
    created() {

        Axios.get('/api/getUserById/1').then((res) => {
            this.form = res.data
        })

    },
    methods: {
      onSave(){
        Axios.post('/api/updateUserById/1',this.form).then((res) => {
          Axios.get('/api/getUserById/1').then((res) => {
            this.form = res.data
        })
          })
      }
    }
}
</script>

<style>
.row {
    margin-bottom: -40px;
}

/* .profileimg{

 } */
.saveprofile {
    margin-top: 40px;
    margin-right: 20px;

}
</style>
