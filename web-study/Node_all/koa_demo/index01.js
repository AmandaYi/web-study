async function testAsync() {
    return "Hello async"
}
function getAngthing() {
    return "something"
}
async function test() {
    const v1 = await getAngthing()
    const v2 = await testAsync()
    console.log(v1, v2)
}
test()