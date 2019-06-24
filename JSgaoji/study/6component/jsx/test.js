/* @jsx h */
// JSX语法
<ul id="1">
    {
        list.map(item => {
            return <li>{item}</li>
        })
    }
    <hr/>
</ul>
