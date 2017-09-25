$.ajaxSetup({
    beforeSend: function () {
        $busy = $("#busy");
        if ($busy.size() == 0) {
            $("body").prepend("<div id='busy'><div id='busy_image'></div></div>");
        }

        $("#busy").css("visibility", "visible");
    },
    complete: function () {
        $("#busy").css("visibility", "hidden");
    }
});
