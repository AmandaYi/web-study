function HOCFactory(Component) {
    return {
        render(h) {
            return h(Component)
        }
    }
}
export default HOCFactory()