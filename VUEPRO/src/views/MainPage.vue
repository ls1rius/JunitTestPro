<template>
    <div id="mainPage">

        <div id="steps-box">
            <el-steps 
            direction="vertical" 
            :space="100" 
            :active=curStep 
            finish-status="success"
            ref="el_steps_box">
                <el-step title="进行中"></el-step>
                <el-step title="步骤 2"></el-step>
                <el-step title="步骤 3"></el-step>
                <el-step title="步骤 4"></el-step>
                <el-step title="步骤 5"></el-step>
            </el-steps>
        </div>

        <div id="content-box">

            <div id="input-username" class="input-box">
                <el-input v-model="inputUsername" placeholder="请输入用户名" style="width:300px;"
                :disabled=disabledState[0]>
                </el-input>
                <el-button type="primary" 
                plain
                style="margin-left:30px;"
                @click="checkUserByUsername(inputUsername)">
                提交
                </el-button>
            </div>

            <div id="select-one" class="select-box">
                <el-select v-model="valueOne" placeholder="请选择" style="width:300px;"
                :disabled=disabledState[1]>
                    <el-option
                    v-for="item in optionsOne"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                <el-button type="primary" 
                plain
                style="margin-left:30px;"
                @click="curStep=1+1">
                提交
                </el-button>
            </div>

            <div id="select-two" class="select-box">
                <el-select v-model="valueTwo" placeholder="请选择" style="width:300px;"
                :disabled=disabledState[2]>
                    <el-option
                    v-for="item in optionsTwo"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                <el-button type="primary" 
                plain
                style="margin-left:30px;"
                @click="curStep=2+1">
                提交
                </el-button>
            </div>

            <div id="select-three" class="select-box">
                <el-select v-model="valueThree" placeholder="请选择" style="width:300px;"
                :disabled=disabledState[3]>
                    <el-option
                    v-for="item in optionsThree"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                <el-button type="primary" 
                plain
                style="margin-left:30px;"
                @click="curStep=3+1">
                提交
                </el-button>
            </div>

            <div id="input-one" class="input-box">
                <el-input v-model="inputOne" placeholder="请输入内容" style="width:300px;"
                :disabled=disabledState[4]
                >
                </el-input>
                <el-button type="primary" 
                plain
                style="margin-left:30px;"
                @click="curStep=4+1">
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
            optionsOne: [
                {
                    value: '选项1',
                    label: '黄金糕'
                }, 
                {
                    value: '选项2',
                    label: '双皮奶'
                }, 
                {
                    value: '选项3',
                    label: '蚵仔煎'
                }, 
                {
                    value: '选项4',
                    label: '龙须面'
                }, 
                {
                    value: '选项5',
                    label: '北京烤鸭'
                }
            ],
            optionsTwo: [
                {
                    value: '选项1',
                    label: '黄金糕'
                }, 
                {
                    value: '选项2',
                    label: '双皮奶'
                }, 
                {
                    value: '选项3',
                    label: '蚵仔煎'
                }, 
                {
                    value: '选项4',
                    label: '龙须面'
                }, 
                {
                    value: '选项5',
                    label: '北京烤鸭'
                }
            ],
            optionsThree: [
                {
                    value: '选项1',
                    label: '黄金糕'
                }, 
                {
                    value: '选项2',
                    label: '双皮奶'
                }, 
                {
                    value: '选项3',
                    label: '蚵仔煎'
                }, 
                {
                    value: '选项4',
                    label: '龙须面'
                }, 
                {
                    value: '选项5',
                    label: '北京烤鸭'
                }
            ],
            valueOne: '',
            valueTwo: '',
            valueThree: '',
            inputUsername: '',
            inputOne: '',
            curStep: 0,
            disabledState: []
        }
    },
    mounted() {
        this.resetTheStepsDisabledState();
    },
    methods: {
        resetTheStepsDisabledState() {
            let stepsNodes = this.$refs.el_steps_box.$children;
            let len = stepsNodes.length;
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
        checkUserByUsername(username) {
            let info = {
                "username":username
            }
            let self = this;
            let url = "http://localhost:8079/user/checkUserByUsername";
            this.axios.post(url,info)
            .then(function (response) {
                console.log(response.data);
                if(response.data.isExist == true){
                    self.curStep = 0+1;
                    self.updateStepState();
                }
            })
            .catch(function (error) {
                console.log(error);
            })
        },
        updateStepState(){
            // console.log(curIndex);
            // console.log(this.$refs.el_steps_box.$children);
            let stepsNodes = this.$refs.el_steps_box.$children;
            // console.log(stepsNodes.length)
            let len = stepsNodes.length;
            for(let i = 0;i<len;i++) {
                if(i == this.curStep){
                    stepsNodes[i].title = "进行中";
                }
                else if(i < this.curStep) {
                    stepsNodes[i].title = "已完成";
                }
                else if(i > this.curStep) {
                    stepsNodes[i].title = "步骤" + i;
                }
            }
            this.resetTheStepsDisabledState();
            console.log(this.disabledState);

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

