Array.from	(json)
(2) ["小明", "18"]0: "小明"1: "18"length: 2__proto__: Array(0)
json  = { 1:"18" ,2:"嘿嘿","length":2}
{1: "18", 2: "嘿嘿", length: 2}
Array.from(json)
(2) [undefined, "18"]
json  = { 1:"18" ,2:"嘿嘿","length":3}
{1: "18", 2: "嘿嘿", length: 3}
Array.from(json)
(3) [undefined, "18", "嘿嘿"]
json  = { 1:"18" ,0:"嘿嘿","length":3}
{0: "嘿嘿", 1: "18", length: 3}
Array.from(json)
(3) ["嘿嘿", "18", undefined]