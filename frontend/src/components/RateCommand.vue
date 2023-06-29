<template>
    <v-card outlined>
        <v-card-title>
            Rate
        </v-card-title>

        <v-card-text>
            <String label="TopicId" v-model="value.topicId" :editMode="editMode"/>
            <Number label="Rate" v-model="value.rate" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="rate"
            >
                Rate
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'RateCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.topicId = '';
            this.value.rate = 0;
        },
        watch: {
        },
        methods: {
            rate() {
                this.$emit('rate', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

