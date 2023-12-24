<template>
    <div id="MyMessage" :style="{backgroundColor: bgColor}">
            {{ text }}
    </div>
</template>

<script>


export default {
    name: 'MyMessage',
    props: {
        bgColor: String,
        text: String
    }
}
</script>

<style scoped>
div#Message {
    border: 1px solid gray; width: 200px;
    height: 150px; box-shadow: 5px 5px 5px gray;
    font-size: 15pt; padding: 20px;
}
</style>
