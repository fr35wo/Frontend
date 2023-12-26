<template>
    <div>{{ time }}</div>
</template> 
<script>
import moment from "moment"; export default {
    name: "MyClock", data() { return { time: null }; },
    mounted() { let callback = () => this.time = moment().format("HH:mm:ss"); 
    console.log(this.time);
    callback(); setInterval(callback, 1000); 
}
} 
</script> 
<style scoped>
div {
    display: inline-block;
    font-size: 15pt;
    padding: 3px 12px;
    border: 1px solid gray;
}
</style>