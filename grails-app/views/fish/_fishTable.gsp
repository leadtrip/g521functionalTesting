<table class="table table-bordered" id="fishTable">
    <tr>
        <th>Name</th>
    </tr>
    <g:each in="${fish}" var="aFish">
        <tr>
            <td>${aFish.name}</td>
        </tr>
    </g:each>
</table>