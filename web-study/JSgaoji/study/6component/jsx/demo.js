// JSX语法
<ul id="1">
    {
        list.map(item => {
            return <li>{item}</li>
        })
    }
    <hr/>
</ul>
React.createElement("ul", {
    id: "1"
  }, list.map(item => {
    return React.createElement("li", null, item);
  }), React.createElement("hr", null));