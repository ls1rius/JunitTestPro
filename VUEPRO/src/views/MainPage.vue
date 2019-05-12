<template>
    <div id="mainPage">

        <div id="steps-box">
            <el-steps 
            direction="vertical" 
            :space="100" 
            :active=curStep 
            finish-status="success"
            ref="el_steps_box">
                <el-step v-for="(steps_titles_item, index) in steps_titles" 
                :title="steps_titles_item.title" v-bind:key="index">

                </el-step>
            </el-steps>
        </div>

        <div id="content-box">

            <div id="input-username" class="input-box">
                <el-input v-model="username" placeholder="请输入用户名" style="width:300px;"
                :disabled=disabledState[0]>
                </el-input>
                <el-button 
                :disabled=disabledState[0]
                type="primary" 
                plain
                style="margin-left:30px;"
                @click="checkUserByUsername()">
                提交
                </el-button>
            </div>

            <div id="select-one" class="select-box">
                <el-select v-model="selectedProduct" placeholder="请选择产品" style="width:300px;"
                :disabled=disabledState[1]>
                    <el-option
                    v-for="item in productOptions"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                <el-button 
                :disabled=disabledState[1]
                type="primary" 
                plain
                style="margin-left:30px;"
                @click="handleSelectProduct()">
                提交
                </el-button>
            </div>

            <div id="input-product-num" class="input-box">
                <el-input v-model="inputProductCount" placeholder="请输入购买数量" style="width:300px;"
                :disabled=disabledState[2]>
                </el-input>
                <el-button 
                :disabled=disabledState[2]
                type="primary" 
                plain
                style="margin-left:30px;"
                @click="handleProductOrder()">
                提交
                </el-button>
            </div>

            <div id="input-product-num" class="input-box">
                <el-input v-model="finishOrderUser" placeholder="请输入完成订单操作者" style="width:300px;"
                :disabled=disabledState[3]>
                </el-input>
                <el-button 
                :disabled=disabledState[3]
                type="primary" 
                plain
                style="margin-left:30px;"
                @click="handleFinishOrder()">
                提交
                </el-button>
            </div>

        </div>

    </div>
</template>
<script>
export default {
    name: 'MainPage',
    data () {
        return {
            msg: 'Welcome to Your Vue.js App',
            steps_titles: [
                {title: '进行中'},
                {title: '步骤 2'},
                {title: '步骤 3'},
                {title: '步骤 4'}
            ],
            productOptions: [],
            username: '',
            userId: '',
            selectedProductId: '',
            selectedProduct: '',
            curStep: 0,
            disabledState: [],
            inputProductCount: '',
            finishOrderUser: '',
            finishOrderUserId: '',
            orderId: ''
        }
    },
    mounted() {
        this.updateStepState();
    },
    methods: {
        resetTheStepsDisabledState() {
            let len = this.steps_titles.length;
            this.disabledState = new Array();
            for (let i =0;i<len;i++){
                if(i==this.curStep){
                    this.disabledState.push(false);
                }
                else{
                    this.disabledState.push(true);
                }
            }
        },
        checkUserByUsername() {
            let info = {
                "username":this.username
            }
            let self = this;
            let url = "http://localhost:8079/user/checkUserByUsername";
            this.axios.post(url,info)
            .then(function (response) {
                // console.log(response.data);
                if(response.data.isExist == true){
                    self.curStep = 0+1;
                    self.username = response.data.username;
                    self.userId = response.data.userId;
                    self.updateStepState();
                    self.getProductOptions();
                }
                else{
                    alert("输入的用户名不存在");
                }
            })
            .catch(function (error) {
                console.log(error);
            })
        },
        getProductOptions(){
            let info = {

            }
            let self = this;
            let url = "http://localhost:8079/product/getProductOptions";
            this.axios.get(url,{params:info})
            .then(function (response) {
                // console.log(response.data.productsList);
                let len = response.data.productsList.length;
                self.productOptions = [];
                for(let i = 0;i<len;i++){
                    var infoModel = {id:'',value:'',label:''};
                    infoModel.id = response.data.productsList[i].id;
                    infoModel.value = response.data.productsList[i].productName;
                    infoModel.label = response.data.productsList[i].productName;
                    self.productOptions.push(infoModel);
                }
                // console.log(self.productOptions);
                
            })
            .catch(function (error) {
                console.log(error);
            })
        },
        updateStepState(){
            let len = this.steps_titles.length;
            for(let i = 0;i<len;i++) {
                if(i == this.curStep){
                    this.steps_titles[i].title = "进行中";
                }
                else if(i < this.curStep) {
                    this.steps_titles[i].title = "已完成";
                }
                else if(i > this.curStep) {
                    this.steps_titles[i].title = "步骤" + i;
                }
            }
            this.resetTheStepsDisabledState();
            // console.log(this.disabledState);

        },
        handleSelectProduct(){
            if(this.selectedProduct==""){
                alert("请选择产品");
            }
            else{
                let len = this.productOptions.length;
                for(let i = 0;i<len;i++){
                    if(this.productOptions[i].value==this.selectedProduct){
                        this.selectedProductId = this.productOptions[i].id;
                        break;
                    }
                }
                this.curStep= 1+1;
                this.updateStepState();
            }
        },
        handleProductOrder(){
            if(this.inputProductCount==""){
                alert("请输入购买数量");
            }
            else{
                this.inputProductCount = parseInt(this.inputProductCount);
                let info = {
                    "username": this.username,
                    "userId": this.userId,
                    "productId": this.selectedProductId,
                    "productName": this.selectedProduct,
                    "productCount": this.inputProductCount
                }
                var self = this;
                let url = "http://localhost:8079/order/createAnOrder";
                this.axios.post(url,info)
                .then(function (response) {
                    // console.log(response.data);
                    alert("订单下达成功");
                    self.curStep= 2+1;
                    self.updateStepState();
                    self.orderId = response.data.orderId;
                    console.log(self.orderId);
                })
                .catch(function (error) {
                    console.log(error);
                })

                console.log(info);


            }
        },
        handleFinishOrder(){
            let info = {
                "username": this.finishOrderUser
            }
            let self = this;
            let url = "http://localhost:8079/user/checkUserByUsername";
            this.axios.post(url,info)
            .then(function (response) {
                // console.log(response.data);
                if(response.data.isExist == true){
                    self.curStep = 3+1;
                    self.updateStepState();
                    self.finishOrderUserId = response.data.userId;
                    self.finishAnOrder();
                }
                else{
                    alert("输入的用户名不存在");
                }
            })
            .catch(function (error) {
                console.log(error);
            })
        },
        finishAnOrder() {
            let info = {
                "finishUserId": this.finishOrderUserId,
                "orderId": this.orderId
            }
            console.log(info);
            let self = this;
            let url = "http://localhost:8079/order/finishAnOrder";
            this.axios.put(url,info)
            .then(function (response) {
                console.log(response.data);
                alert("完成订单成功");
            })
            .catch(function (error) {
                console.log(error);
            })
        }
    }
}
</script>
<style scoped>
#mainPage {
    width: 100vw;
    height: 100vh;
    background: lightyellow;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    padding: 100px;
    box-sizing: border-box;
}
#steps-box {
    width: 100px;
    padding-top: 10px;
    margin-right: 50px;
    box-sizing: border-box;

}
.select-box {
    width: 100%;
    height: 100px;
    /* display: flex;
    justify-content: center;
    align-items: center; */
}
.input-box {
    width: 100%;
    height: 100px;
    /* display: flex;
    justify-content: center;
    align-items: center; */
}

</style>

