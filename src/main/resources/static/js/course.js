$(document).ready(function () {
    
    $.ajax({
        url: "http://217.182.230.17:8080/lectures/list"
    }).then(function(data) {
        var i=0;
        var j=0;        
        for(i=0;i<data.length;i++){
        	var subgroups="";
        	// for(j=0;i<data[i].subGroups.length;i++){
        	// 	subgroups=subgroups+ data[i].subGroups[j].name;
        	// }

            $("#definedCourses").append('<tr><td data-title="ردیف">'+(i+1)+'</td><td data-title="نام درس">'+data[i].name+'</td><td data-title="شماره درس" class="numeric">'+data[i].code+'</td><td data-title="تعداد واحد تئوری" class="numeric">'+data[0].theoreticalUnitCount+'</td><td data-title="تعداد واحد عملی" class="numeric">'+data[0].practicalUnitCount+'</td><td data-title="زیرگروه" class="numeric">'+data[i].subGroups[0].name+'</td><td data-title="مدیریت" class="numeric"><span class="glyphicon glyphicon-remove" style="margin-left: 5px;" aria-hidden="true"></span><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></td></tr>'
            );
        }
    });
    function addLecture() {
    	var name=$("#lecName");
    	var code=$("#lecCode");
    	var prUnit=$("#lecPracUnit");
    	var thUnit=$("#lecTheorUnit");
    }
});