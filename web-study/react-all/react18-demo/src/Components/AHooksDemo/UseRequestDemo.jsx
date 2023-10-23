import React,{useState} from "react"
import { useRequest } from "ahooks"
function getUserName() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve("ok")
        }, 1000)
    })
}
function UseRequestDemo(props) {
    const [userId, setUserId] = useState('1');
    const { data, error, loading } = useRequest(getUserName, {
        refreshDeps: [userId],
        // pollingInterval: 3000,
        onBefore(){
            console.log("onBefore")
        },
        onSuccess(){
            console.log("onSuccess")
        },
        onError(){
            console.log("onError")
        },
        onFinally(){
            console.log("onFinally")
        }
    })
    console.log(data)
    return (<>

    </>)
}
export default UseRequestDemo