Feature: To user verify all menus in home page
Scenario: To user validate top level menu
Given To user launch a chrome browser and pass valid "<url>"
				|https://www.tendable.com/|
When To user verify the confirm accessibility of the toplevel menus home,our story,our solution, and why Tendable.



Scenario: To user validate request a demo element
When To user check  request a demo button  is present and click request a demo button 
And  To user check all top level menus are present 
 




Scenario: To user validate contact us function
When To user click contact us button and click marketing button
And To user fill all field and click submit button 
