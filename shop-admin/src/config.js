import Axios from 'axios'
import {
    Message
} from 'element-ui'

// 配置
const service = Axios.create({
    baseURL: 'http://127.0.0.1:8090/api/',
    timeout: 50000
})

// 响应拦截
service.interceptors.response.use(
    response => {
        if (response.data.status != 200) {
            Message.error(response.data.message)
        }

        return response.data;
    }, error => {
        Message.error(error)
        return Promise.reject(error)
    }
)

export default service