<template>
    <div class="col-lg-8 col-md-10 mx-auto">
        <div v-for="item in lstBlog" :key="item.id" class="post-preview">
            <hr>
            <router-link :to="{path: '/blog/' + item.id}">
                <h2 class="post-title">
                    {{ item.title }}
                </h2>
                <h3 class="post-subtitle">
                    {{ item.description }}
                </h3>
            </router-link>
            
            <p class="post-meta">Posted by <router-link :to="{path: '/about'}">{{ item.createdBy }}</router-link> on {{  item.createdDate | moment("MMMM DD, YYYY") }}.</p>
        </div>
        <!-- Pager -->
        <hr>
        <div v-if="lstBlog != null" class="post-preview text-center" >
            <p>{{ currentPage }} / {{ lastPage }} pages and {{ count }} blogs.</p>
        </div>
        <div v-if="lstBlog == null" class="post-preview text-center">
            <p>404 not found list blog.</p>
        </div>
        <div class="row">
            <div v-if="currentPage > 1" class="col-sm">
                <div class="clearfix">
                    <router-link :to="{path: '/list_blog/' + prevPage}">
                        <a class="btn btn-primary float-left">&larr; Newer Posts</a>
                    </router-link>
                </div>
            </div>
            <div v-if="currentPage < lastPage" class="col-sm">
                <div class="clearfix">
                    <router-link :to="{path: '/list_blog/' + nextPage}">
                        <a class="btn btn-primary float-right">Older Posts &rarr;</a>
                    </router-link>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import axios from 'axios'
    export default {
        data () {         
            return {
                count: null,
                currentPage: null,
                lastPage: null,
                nextPage: null,
                prevPage: null,
                lstBlog: null
            }
        },
        mounted() {
            axios.get('http://localhost:8082/cli/blog/get_all').then((response) => {
                this.count = response.data.responseListBlogResult.count,
                this.currentPage = response.data.responseListBlogResult.currentPage,
                this.lastPage = response.data.responseListBlogResult.lastPage,
                this.nextPage = response.data.responseListBlogResult.currentPage+1,
                this.prevPage = response.data.responseListBlogResult.currentPage-1,
                this.lstBlog = response.data.responseListBlogResult.lstBlogModel
            })
        }
    }
</script>