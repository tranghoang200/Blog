<template>
    <div class="col-lg-8 col-md-10 mx-auto">
        <div v-if="blog != null" class="post-preview">
            <hr>
            <h2 class="post-title">
                {{ blog.title }}
            </h2>
            <p class="post-meta">Posted by <router-link :to="{path: '/about'}">{{ blog.createdBy }}</router-link> on {{  blog.createdDate | moment("MMMM DD, YYYY") }}.</p>
            <p>
                {{ blog.content }}
            </p>
        </div>
        <div v-if="blog == null" class="post-preview text-center">
            <hr>
            404 not found this blog.
        </div>
        {{info}}
    </div>
</template>
<script>
    import axios from 'axios'
    export default {
        data () {         
            return {
                errorMessage: null,
                blog: null
            }
        },
        mounted() {
            axios.get('http://localhost:8082/cli/blog/' + this.$route.params.id).then((response) => {
                if(response.data.responseBlogResult != null) {
                    this.errorMessage = response.data.errorMessage,
                    this.blog = response.data.responseBlogResult.blogModel
                } else{
                    this.errorMessage = response.data.errorMessage
                }
            })
        },
    }
</script>