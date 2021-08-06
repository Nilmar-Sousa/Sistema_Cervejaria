<?php

Class homeController extends Controller {

    public function index(){
        //Chama um model
        //Chama uma view
        $this->carregarTemplate('home');
    }

}
?>