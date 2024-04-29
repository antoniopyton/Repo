--1
select * from public.clienti where nome = 'Mario';
--2
select nome, cognome from public.clienti where anno_nascita = 1982;
--3
select * from public.numero_fattura where iva = 20;
--3bis
select count (*) from public.numero_fattura where iva = 20;
--4
select * from public.prodotti where data_attivazione = 2017 and (in_produzione = true or in_commercio = true);
--5
select * from public.numero_fattura f inner join public.clienti c on f.id_cliente= c.numero_cliente where importo < 4000;
--6

--7
select extract(year from data_fattura) anno, count (*) numero_fatture 
from public.numero_fattura where iva = 20 group by anno; 
--8
select extract(year from data_fattura) anno, count (*) numero_fatture, sum(importo) importo_totale
from public.numero_fattura group by anno; 