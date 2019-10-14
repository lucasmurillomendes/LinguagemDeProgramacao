/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  aluno
 * Created: 02/10/2019
 */
create database agenda;

create table contato (
    id int not null auto_increment primary key,
    nome varchar(40),
    idade int,
    dataCadastro date
);