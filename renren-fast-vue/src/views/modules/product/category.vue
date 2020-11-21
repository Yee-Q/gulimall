<template>
  <div>
    <el-tree :data="menus" :props="defaultProps" @node-click="handleNodeClick"
             :expand-on-click-node="false" show-checkbox node-key="catId" :default-expanded-keys="expandedKey">
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button v-if="node.level <= 2" type="text" size="mini" @click="() => append(data)">Append</el-button>
          <el-button v-if="node.childNodes.length === 0" type="text" size="mini" @click="() => remove(node, data)">Delete</el-button>
        </span>
      </span>
    </el-tree>
    <el-dialog title="提示" :visible.sync="dialogVisible" width="30%" :before-close="handleClose">
      <el-form :model="category">
        <el-form-item label="分类名称">
          <el-input v-model="category.name" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addCategory()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>

  export default {
    data() {
      return {
        category: {name: "", parentCid: 0, catLevel: 0, showStatus: 1, sort: 0},
        dialogVisible: false,
        menus: [],
        expandedKey: [2],
        defaultProps: {
          children: 'children',
          label: 'name'
        }
      };
    },
    methods: {
      append(data) {
        console.log("append", data);
        this.dialogVisible = true;
        this.category.parentCid = data.catId;
        this.category.catLevel = data.catLevel + 1;
      },
      // 添加三级分类
      addCategory() {
        console.log("提交的三级分类数据", this.category);
        this.$http({
          url: this.$http.adornUrl("/product/category/save"),
          method: "post",
          data: this.$http.adornData(this.category, false)
        }).then(({data}) => {
          this.$message({
            message: "菜单保证成功",
            type: "success"
          })
          // 关闭对话框
          this.dialogVisible = false;
          // 刷新出新的菜单
          this.getMenus();
          // 设置需要默认展开的菜单
          this.expandedKey = [this.category.parentCid];
        });
      },
      remove(node, data) {
        var ids = [data.catId];
        this.$confirm(`是否删除【${data.name}】菜单?`, '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.$http({
            url: this.$http.adornUrl("/product/category/delete"),
            method: 'post',
            data: this.$http.adornData(ids, false)
          }).then(({data}) => {
            this.$message({
              message: "菜单删除成功",
              type: "success"
            });
            // 刷新出新的菜单
            this.getMenus();
            // 设置需要默认展开的菜单
            this.expandedKey = [node.parent.data.catId];
          });
        }).catch(() => {

        });
      },
      getMenus() {
        this.$http({
          url: this.$http.adornUrl("/product/category/list/tree"),
          method: 'get'
        }).then(({data}) => {
          console.log("成功获取到菜单数据", data.data);
          this.menus = data.data;
        })
      }
    },

    beforeCreate() {
    },

    //生命周期 - 创建完成（可以访问当前this实例）",数据模型已加载，方法已加载,html模板已加载,html模板未渲染
    created() {
      this.getMenus();
    },
    //生命周期 - 挂载之前",html模板未渲染
    beforeMount() {

    },

    //生命周期 - 挂载完成（可以访问DOM元素）",html模板已渲染
    mounted() {

    },

    //生命周期 - 更新之前",数据模型已更新,html模板未更新
    beforeUpdate() {

    },
    //生命周期 - 更新之后",数据模型已更新,html模板已更新
    updated() {

    },
    //生命周期 - 销毁之前",
    beforeDestroy() {

    },
    destroyed() {

    },
    //生命周期 - 销毁完成",
    //如果页面有keep-alive缓存功能，这个函数会触发",
    activated() {

    },
  }


  // "http-get请求": {
  //   "prefix": "httpget",
  //     "body": [
  //     "this.\({",
  //     "url: this.\\$http.adornUrl(''),",
  //     "method: 'get',",
  //     "params: this.\\$http.adornParams({})",
  //     "}).then(({ data }) => {",
  //     "})"
  //   ],
  //     "description": "httpGET请求"
  // },
  // "http-post请求": {
  //   "prefix": "httppost",
  //     "body": [
  //     "this.\({",
  //     "url: this.\\$http.adornUrl(''),",
  //     "method: 'post',",
  //     "data: this.\\$http.adornData(data, false)",
  //     "}).then(({ data }) => { });"
  //   ],
  //     "description": "httpPOST请求"
  // }
  // }

</script>

<style>

</style>
