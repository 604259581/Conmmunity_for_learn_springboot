function mypost() {
    var questionId = $("#question_id").val();
    var content = $("#comment_content").val();
    comment2Target(questionId, 1, content);
}

/**
 * 展开二级评论
 */
// function collapseComments(e) {
//     var id = e.getAttribute("data-id");
//     var comment = $("#comment-" + id);
//     var attribute = e.getAttribute("data-collapse");
//     if (attribute) {
//         comment.removeClass("in");
//         e.removeAttribute("data-collapse");
//         e.classList.remove("active");
//     } else {
//         $.getJSON("/comment/" + id, function (data) {
//             var subCommentContainer = $("#comment-" + id);
//             // if (subCommentContainer.children().length != 1) {
//             //     comment.addClass("in");
//             //     e.setAttribute("data-collapse", "in");
//             //     e.classList.add("active");
//             // } else {
//             $.each(data.data.reverse(), function (index, comment) {
//
//                 var mediaLeftElement = $("<div/>", {
//                     "class": "media-left"
//                 }).append($("<img/>", {
//                     "class": "media-object img-rounded",
//                     "src": comment.user.picture
//                 }));
//                 var mediaElement = $("<div/>", {
//                     "class": "media"
//                 }).append(mediaLeftElement);
//
//                 var mediaBodyElement = $("<div/>", {
//                     "class": "media-body"
//                 }).append($("<h6/>", {
//                     "class": "media-heading",
//                     "html": comment.user.name
//                 })).append($("<div/>", {
//                     "src": comment.comment
//                 })).append($("<div/>", {
//                     "class": "menu"
//                 }).append($("<span/>", {
//                     "class": "pull-right",
//                     "html": comment.gmtGreate
//                 })));
//
//
//                 var mediaElement = $("<div/>", {
//                     "class": "media"
//                 }).append(mediaLeftElement);
//
//                 var commentElement = $("<div/>", {
//                     "class": "col-xs-12 col-md-12 col-sm-12 col-lg-12 comments",
//                     html: comment.comment
//                 }).append(mediaElement)
//                     .append(mediaBodyElement);
//                 subCommentContainer.prepend(commentElement);
//             });
//             comment.addClass("in");
//             e.setAttribute("data-collapse", "in");
//             e.classList.add("active");
//             // }
//         });
//
//     }
//
// }
function collapseComments(e) {
    var id = e.getAttribute("data-id");
    var comments = $("#comment-" + id);

    // 获取一下二级评论的展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse) {
        // 折叠二级评论
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        var subCommentContainer = $("#comment-" + id);
        // if (subCommentContainer.children().length != 1) {
            //展开二级评论
            comments.addClass("in");
            // 标记二级评论展开状态
            e.setAttribute("data-collapse", "in");
            e.classList.add("active");
        // } else {
            $.getJSON("/comment/" + id, function (data) {
                $.each(data.data.reverse(), function (index, comment) {
                    var mediaLeftElement = $("<div/>", {
                        "class": "media-left"
                    }).append($("<img/>", {
                        "class": "media-object img-rounded",
                        "src": comment.user.picture
                    }));

                    var mediaBodyElement = $("<div/>", {
                        "class": "media-body"
                    }).append($("<h5/>", {
                        "class": "media-heading",
                        "html": comment.user.name
                    })).append($("<div/>", {
                        "html": comment.comment
                    })).append($("<div/>", {
                        "class": "menu"
                    }).append($("<span/>", {
                        "class": "pull-right",
                         "html":comment.gmtCreate
                        //"html":moment(comment.gmtCreate).format('YYYY-MM-DD')
                    })));

                    var mediaElement = $("<div/>", {
                        "class": "media"
                    }).append(mediaLeftElement).append(mediaBodyElement);

                    var commentElement = $("<div/>", {
                        "class": "col-lg-12 col-md-12 col-sm-12 col-xs-12 comments"
                    }).append(mediaElement);

                    subCommentContainer.prepend(commentElement);
                });
                //展开二级评论
                comments.addClass("in");
                // 标记二级评论展开状态
                e.setAttribute("data-collapse", "in");
                e.classList.add("active");
            });
        }

}



function comment2Target(targetId, type, content) {
    if (!content) {
        alert("不能回复空内容");
        return
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId": targetId,
            "content": content,
            "type": type
        }),
        success: function (response) {
            if (response.code == 200) {
                //$("#comment_section").hide();
                window.location.reload();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=8d85751662c5e1df0bdd&amp;redirect_url=http://localhost:8080/callback&amp;scope=user&amp;state=1");
                        window.localStorage.setItem("closable", true);
                    }
                } else {
                    alert(response.message);
                }
            }
            console.log(response);
        },
        dataType: "json"
    });
}

function comment(e) {
    var commentId = e.getAttribute("data-id")
    var content = $("#input-" + commentId).val();
    comment2Target(commentId, 2, content);
}
function selectTag(e) {
    var value = e.getAttribute("data-tag");
    var previous = $("#tag").val();

    if(previous.indexOf(value)==-1){
        if(previous){
            $("#tag").val(previous+','+value);
        }else{
            $("#tag").val(value);
        }
    }

}
function showSelectTag() {
    $("#select-tag").show();
}