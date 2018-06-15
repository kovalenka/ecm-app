require(["dojo/dom", "dojo/on", "dojo/request", "dojo/dom-form"],
    function(dom, on, request, domForm){

        var form = dom.byId('formPost');

        // Attach the onsubmit event handler of the form
        on(form, "submit", function(evt){

            // prevent the page from navigating after submit
            evt.stopPropagation();
            evt.preventDefault();

            // Post the data to the server
            request.post("/EcmApp/webapi/employees/create", {
                // Send the username and other things
                data: domForm.toObject("formPost"),
                // Wait 2 seconds for a response
                timeout: 4000

            }).then(function(response){
                dom.byId('svrMessage').innerHTML = "<pre>" + response + "</pre>";
            },
            function(error) {
				// Display the error returned
            	dom.byId('svrMessage').innerHTML = "<div class=\"error\">" + error
						+ "<div>";
			});
        });
    }
);