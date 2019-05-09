$(document).ready(function () {
    $('#loadOlderPosts').on('click',function () {
        console.log('click');
        var page = $(this).attr('data-page');

        $.ajax({
            url: "postsArray.jsp?page=" + page,
            type: 'GET',
            contentType: "application/json; charset=utf-8",
            dataType: "html",
            success: function(res) {
                console.log(res);
                $('#postsContainer').append(res);
                $('#loadOlderPosts').attr('data-page',++page);
            }
        });
    })
});
