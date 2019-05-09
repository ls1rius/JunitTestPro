<template>
    <div id="mainPage">

        <div id="step-box">
            <el-steps 
            direction="vertical" 
            :space="100" 
            :active="1" 
            finish-status="success">
                <el-step title="已完成"></el-step>
                <el-step title="进行中"></el-step>
                <el-step title="步骤 3"></el-step>
                <el-step title="步骤 4"></el-step>
                <el-step title="步骤 5"></el-step>

            </el-steps>
        </div>

        <div id="content-box">

            <div id="select-one" class="select-box">
                <el-select v-model="valueOne" placeholder="请选择" style="width:300px;">
                    <el-option
                    v-for="item in optionsOne"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                <el-button type="primary" 
                plain
                style="margin-left:30px;">
                提交
                </el-button>
            </div>

            <div id="select-two" class="select-box">
                <el-select v-model="valueTwo" placeholder="请选择" style="width:300px;">
                    <el-option
                    v-for="item in optionsTwo"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                <el-button type="primary" 
                plain
                style="margin-left:30px;">
                提交
                </el-button>
            </div>

            <div id="select-three" class="select-box">
                <el-select v-model="valueThree" placeholder="请选择" style="width:300px;">
                    <el-option
                    v-for="item in optionsThree"
                    :key="item.value"
                    :label="item.label"
                    :value="item.value">
                    </el-option>
                </el-select>
                <el-button type="primary" 
                plain
                style="margin-left:30px;">
                提交
                </el-button>
            </div>

            <div id="input-one" class="input-box">
                <el-input v-model="inputOne" placeholder="请输入内容" style="width:300px;"></el-input>
                <el-button type="primary" 
                plain
                style="margin-left:30px;">
                提交
                </el-button>
            </div>

            <div id="input-two" class="input-box">
                <el-input v-model="inputTwo" placeholder="请输入内容" style="width:300px;"></el-input>
                <el-button type="primary" 
                plain
                style="margin-left:30px;">
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
            checkedSelectOne: false,
            checkedInputOne: false,
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
            inputOne: '',
            inputTwo: ''

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
#step-box {
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

