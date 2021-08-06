<?php

Class Core{

    public function __construct(){
        $this->run();
    }

    public function run(){
        if(isset($_GET['pag'])){
            $url = $_GET['pag']
        }
        // Possui informação após dominio
        if(!empty($url)){
            $url = explode('/', $url);
            $controller = $url[0].'Controller';
            array_shift($url);
            // Se o usuário mandou função
            if(isset($url[0]) && !empty($url[0])){
                $metodo = $url[0];
                array_shift($url);
            }else { // Enviou somente a classe
                $metodo = 'index';
            }
            if(count($url) > 0){
                $parametros = $url;
            }
        }else {
            $controller = 'homeController';
            $metodo = 'index';
        }
        $caminho = 'Sistema_Cervejaria/Controllers/'.$controller.'.php';
        if(!file_exists($caminho) && !method_exists($controller, $metodo)){
            $controller = 'homeController';
            $metodo = 'index';
        }
        $c = new $controller;
        call_user_func_array(array($c,$metodo), $parametros;)
    }
}


?>