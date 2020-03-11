<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet">

        <title>Calculate Sum Subsets</title>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col">
                    <form:form action="submitForm" modelAttribute="form">
                        <h4>
                            Submit a desired sum and a list of numbers to see which ones add up to the sum
                        </h4>
                        <div class="form-group">
                            <label for="totalField">
                                Desired sum:
                            </label>
                            <form:input id="totalField" type="text" class="form-control" path="total" aria-describedby="totalHelp"/>
                            <form:errors path="total" cssClass="error"/>
                            <small id="totalHelp" class="form-text text-muted">
                                Must be an integer
                            </small>
                        </div>
                        <div class="form-group">
                            <label for="listField">
                                List of numbers:
                            </label>
                            <form:input id="listField" type="text" class="form-control" path="list" aria-describedby="listHelp"/>
                            <form:errors path="list" cssClass="error"/>
                            <small class="form-text text-muted">
                                Must be a comma-delimited set of unique integers with no spaces
                            </small>
                        </div>
                        <input class="btn btn-primary" type="submit" value="Submit">
                    </form:form>
                </div>
            </div>
            <br><br>
            <div class="row justify-content-center">
                <div class="col">
                    <h2>
                        Result:
                    </h2>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <div id="results">
                        <h4>
                            ${result}
                        </h4>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
        <script>
            // I couldn't take the extra time to do something cool with jQuery,
            // but I have plenty of jQuery code I've contributed as a contractor
            // that I'm sure the owners would be cool with me showing you.
            console.log("Results: " + $('#results').text().trim);
        </script>
    </body>
</html>