
/*function suma(){
    var total = 0;
    $(".A").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total += 0;
    } else {
        total += parseFloat($(this).val());
    }
    });
    document.getElementById('tot1').innerHTML = total;
}

function sumIni(){
    var total = 0;
    document.getElementById('tot1').innerHTML = total;
*/

function suma2(){
    var total2 = 0;
    $(".H1").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total2 += 0;
    } else {
        total2 += parseFloat($(this).val());
    }
    });
    document.getElementById('tot2').innerHTML = total2;
}

function suma3(){
    var total3 = 0;
    $(".H3").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total3 += 0;
    } else {
        total3 += parseFloat($(this).val());
    }
    });
    document.getElementById('tot3').innerHTML = total3;
}

function suma4(){
    var total4 = 0;
    $(".B").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total4 += 0;
    } else {
        total4 += parseFloat($(this).val());
    }
    });
    document.getElementById('tot4').innerHTML = total4;
}

function suma5(){
    var total5 = 0;
    
  
     $(".A").each(function() {
         $(".H1").each(function() {
            $(".H3").each(function() {
              $(".B").each(function() {
                if (isNaN(parseFloat($(this).val()))) {
                    total5 += 0;
                } else {
                    total5 += parseFloat($(this).val());
                }
                });
            });
        });
     });
    document.getElementById('tot5').innerHTML = total5;
}

function suma_t4(){
    var total_t4 = 0;
    $(".DEFC").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total_t4 += 0;
    } else {
        total_t4 += parseFloat($(this).val());
    }
    });
    document.getElementById('tot_t4').innerHTML = total_t4;
}

function sumat5_1(){
    var total_t5 = 0;
    $(".t5_A").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total_t5 += 0;
    } else {
        total_t5 += parseFloat($(this).val());
    }
    });
    document.getElementById('t5_tot1').innerHTML = total_t5;
}

function sumat5_2(){
    var total_t5_1 = 0;
    $(".t5_H1").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total_t5_1 += 0;
    } else {
        total_t5_1 += parseFloat($(this).val());
    }
    });
    document.getElementById('t5_tot2').innerHTML = total_t5_1;
}

function sumat5_3(){
    var total_t5_2 = 0;
    $(".t5_H3").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total_t5_2 += 0;
    } else {
        total_t5_2 += parseFloat($(this).val());
    }
    });
    document.getElementById('t5_tot3').innerHTML = total_t5_2;
}

function sumat5_4(){
    var total_t5_3 = 0;
    $(".t5_B").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total_t5_3 += 0;
    } else {
        total_t5_3 += parseFloat($(this).val());
    }
    });
    document.getElementById('t5_tot4').innerHTML = total_t5_3;
}

function sumat6(){
    var total_t6 = 0;
    $(".VCINFLU").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total_t6 += 0;
    } else {
        total_t6 += parseFloat($(this).val());
    }
    });
    document.getElementById('tot_t6').innerHTML = total_t6;
}

function sumat7(){
    var total_t7 = 0;
    $(".OSACU").each(function() {
    if (isNaN(parseFloat($(this).val()))) {
        total_t7 += 0;
    } else {
        total_t7 += parseFloat($(this).val());
    }
    });
    document.getElementById('tot_t7').innerHTML = total_t7;
}

$('body').on('keydown', 'input', function(e) {
    var self = $(this)
      , form = self.parents('form:eq(0)')
      , focusable
      , next
      ;
    if (e.keyCode === 13) {
        focusable = form.find('input,a,select,button,textarea').filter(':visible');
        next = focusable.eq(focusable.index(this)+1);
        if (next.length) {
            next.focus();
        } else {
            form.submit();
        }
        return false;
    }
});