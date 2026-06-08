-- Satelites
insert into satelite (id,nome,agencia,tipo,altitude_km,dias_revisita,status,cobertura,descricao,ultima_passagem,proxima_passagem) values ('sentinel-1','Sentinel-1','ESA','SAR',693,6,'ativo','Atlantico Sul - Amazonia','Radar de abertura sintetica - detecta embarcacoes e movimentos mesmo a noite e sob nuvens.','2026-05-25 10:32:00','2026-05-25 22:18:00');
insert into satelite (id,nome,agencia,tipo,altitude_km,dias_revisita,status,cobertura,descricao,ultima_passagem,proxima_passagem) values ('sentinel-2','Sentinel-2','ESA','Optico',786,5,'ativo','Amazonia - Cerrado','Sensor multiespectral de 13 bandas - ideal para monitoramento de vegetacao e deteccao de desmatamento.','2026-05-25 08:15:00','2026-05-25 20:45:00');
insert into satelite (id,nome,agencia,tipo,altitude_km,dias_revisita,status,cobertura,descricao,ultima_passagem,proxima_passagem) values ('landsat-8','Landsat-8','NASA','Multiespectral',705,16,'passando','Centro-Oeste - Sul do Brasil','Sensor OLI e TIRS - captura imagens no visivel, infravermelho e infravermelho termico.','2026-05-24 14:20:00','2026-05-26 14:05:00');
insert into satelite (id,nome,agencia,tipo,altitude_km,dias_revisita,status,cobertura,descricao,ultima_passagem,proxima_passagem) values ('noaa-20','NOAA-20','NOAA','Radar',824,1,'ativo','Global','Monitoramento climatico global - temperatura oceanica e cobertura de nuvens.','2026-05-25 06:15:00','2026-05-25 18:30:00');

-- Casos
insert into caso (id,alerta_id,titulo,nivel,status,agente_id,agente_nome,abertura_em,atualizado_em,notas) values ('caso-042','alerta-001','Pesca Ilegal - Atlantico Sul A3','critico','aberto','agente-001','Agente R. Silva','2026-05-25 09:20:00','2026-05-25 09:20:00','');
insert into caso (id,alerta_id,titulo,nivel,status,agente_id,agente_nome,abertura_em,atualizado_em,notas) values ('caso-041','alerta-004','Trafico - Fronteira Sul F1','critico','em_analise','agente-001','Agente R. Silva','2026-05-25 04:00:00','2026-05-25 07:30:00','');
insert into caso (id,alerta_id,titulo,nivel,status,agente_id,agente_nome,abertura_em,atualizado_em,notas) values ('caso-039','alerta-002','Desmatamento - Amazonia C7','medio','em_analise','agente-001','Agente R. Silva','2026-05-24 15:00:00','2026-05-24 18:45:00','');
insert into caso (id,alerta_id,titulo,nivel,status,agente_id,agente_nome,abertura_em,atualizado_em,notas) values ('caso-035','alerta-003','Pesca Suspeita - Para B2','baixo','aberto','agente-001','Agente R. Silva','2026-05-23 11:30:00','2026-05-23 11:30:00','');
insert into caso (id,alerta_id,titulo,nivel,status,agente_id,agente_nome,abertura_em,atualizado_em,fechado_em,notas) values ('caso-033','alerta-005','Desmatamento - Rondonia D4','medio','resolvido','agente-001','Agente R. Silva','2026-05-22 10:30:00','2026-05-23 16:00:00','2026-05-23 16:00:00','Area autuada. Responsavel identificado e multado.');
insert into caso (id,alerta_id,titulo,nivel,status,agente_id,agente_nome,abertura_em,atualizado_em,notas) values ('caso-031','alerta-006','Anomalia Termica - Brasilia G2','baixo','aberto','agente-001','Agente R. Silva','2026-05-21 08:30:00','2026-05-21 08:30:00','');

-- Alertas
insert into alerta (id,nivel,tipo_ameaca,confianca,lat,lon,regiao,detectado_em,descricao,status,caso_id,fk_satelite,fk_caso) values ('alerta-001','critico','pesca_ilegal',97,-23.5,-42.1,'Atlantico Sul - Setor A3','2026-05-25 09:15:00','3 embarcacoes tipo B detectadas em zona de exclusao.','aberto','caso-042','sentinel-2','caso-042');
insert into alerta (id,nivel,tipo_ameaca,confianca,lat,lon,regiao,detectado_em,descricao,status,caso_id,fk_satelite,fk_caso) values ('alerta-002','medio','desmatamento',81,-4.5,-55.2,'Amazonia Legal - Setor C7','2026-05-24 14:30:00','Variacao vegetal expressiva detectada - possivel corte ilegal em area de protecao.','em_analise','caso-039','landsat-8','caso-039');
insert into alerta (id,nivel,tipo_ameaca,confianca,lat,lon,regiao,detectado_em,descricao,status,caso_id,fk_satelite,fk_caso) values ('alerta-003','baixo','pesca_ilegal',63,-1.2,-48.5,'Para - Setor B2','2026-05-23 11:00:00','Embarcacao de pequeno porte em area restrita. Baixa confianca - requer verificacao.','aberto','caso-035','sentinel-1','caso-035');
insert into alerta (id,nivel,tipo_ameaca,confianca,lat,lon,regiao,detectado_em,descricao,status,caso_id,fk_satelite,fk_caso) values ('alerta-004','critico','trafico',89,-33.4,-53.2,'Fronteira Sul - Setor F1','2026-05-25 03:45:00','Movimento noturno suspeito em regiao de fronteira. Padrao compativel com rota de trafico.','em_analise','caso-041','noaa-20','caso-041');
insert into alerta (id,nivel,tipo_ameaca,confianca,lat,lon,regiao,detectado_em,descricao,status,caso_id,fk_satelite,fk_caso) values ('alerta-005','medio','desmatamento',76,-8.3,-63.1,'Rondonia - Setor D4','2026-05-22 10:20:00','Area de 2.3 km2 com supressao vegetal detectada.','resolvido','caso-033','sentinel-2','caso-033');
insert into alerta (id,nivel,tipo_ameaca,confianca,lat,lon,regiao,detectado_em,descricao,status,caso_id,fk_satelite,fk_caso) values ('alerta-006','baixo','anomalia',55,-15.8,-47.9,'Brasilia - Setor G2','2026-05-21 08:00:00','Anomalia termica detectada em area industrial.','aberto','caso-031','landsat-8','caso-031');

-- Eventos da linha do tempo
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-001','caso-042','Alerta detectado pelo Sentinel-2 na zona de exclusao A3.','2026-05-25 09:15:00','deteccao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-002','caso-042','Caso aberto e atribuido ao Agente R. Silva.','2026-05-25 09:20:00','atribuicao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-010','caso-041','Movimento noturno detectado pelo NOAA-20 as 03:45.','2026-05-25 03:45:00','deteccao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-011','caso-041','Caso aberto. Prioridade critica.','2026-05-25 04:00:00','atribuicao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-012','caso-041','Analise de rota em andamento.','2026-05-25 07:30:00','atualizacao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-020','caso-039','Variacao vegetal detectada pelo Landsat-8 no setor C7.','2026-05-24 14:30:00','deteccao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-021','caso-039','Caso aberto. Area estimada: 3.2 km2.','2026-05-24 15:00:00','atribuicao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-022','caso-039','IBAMA notificado.','2026-05-24 18:45:00','atualizacao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-030','caso-035','Embarcacao detectada pelo Sentinel-1 em area restrita.','2026-05-23 11:00:00','deteccao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-031','caso-035','Caso aberto. Aguardando confirmacao visual.','2026-05-23 11:30:00','atribuicao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-040','caso-033','Supressao vegetal detectada pelo Sentinel-2.','2026-05-22 10:20:00','deteccao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-041','caso-033','Caso aberto. Area de 2.3 km2 identificada.','2026-05-22 10:30:00','atribuicao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-042','caso-033','Fiscalizacao em campo confirmou o desmatamento.','2026-05-23 09:00:00','atualizacao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-043','caso-033','Auto de infracao emitido. Caso encerrado.','2026-05-23 16:00:00','resolucao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-050','caso-031','Anomalia termica detectada pelo Landsat-8.','2026-05-21 08:00:00','deteccao');
insert into evento_linha_tempo (id,fk_caso,mensagem,timestamp,tipo) values ('lt-051','caso-031','Caso aberto. Investigacao preliminar iniciada.','2026-05-21 08:30:00','atribuicao');

-- Usuario: RM1 | senha: senha
insert into pessoa(nome,cpf,data_nascimento,email_pessoal) values('Admin SentinelEye','220.453.840-04','2000-01-01','admin@sentineleye.com');
insert into usuario(fk_pessoa,rm,senha,permissao,data_criacao,status) values(1,'RM1','$2a$12$Du8BqD6ZgbjJ5xly8/NJ3unipbl.WQlI2mNTtGs3VmzwujO2keUnu','USER','2026-05-01','ATIVO');
