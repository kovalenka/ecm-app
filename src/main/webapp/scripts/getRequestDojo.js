require([ "dojo/dom", "dojo/on", "dojo/request", "dojo/domReady!" ], function(
		dom, on, request) {

    var form = dom.byId('formGet');

    // Attach the onsubmit event handler of the form
    on(form, "submit", function(evt){

        // prevent the page from navigating after submit
        evt.stopPropagation();
        evt.preventDefault();

		// Request the text file
		request.get("/EcmApp/webapi/employees/get").then(
            // Results will be displayed in svrMessage2
            function(response) {
					// Display the text file content
                    dom.byId('svrMessage2').innerHTML = "<pre>" + response + "</pre>";
				},
				function(error) {
					// Display the error returned
                    dom.byId('svrMessage2').innerHTML = "<div class=\"error\">" + error
							+ "<div>";
				});
	});
});