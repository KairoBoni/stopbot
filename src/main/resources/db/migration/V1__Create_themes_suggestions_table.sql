CREATE TABLE public.themes_suggestions (
	id SERIAL NOT NULL,
	first_letter bpchar(1) NOT NULL,
	suggestion varchar(255) NOT NULL,
	theme varchar(255) NOT NULL,
	CONSTRAINT themes_suggestions_pkey PRIMARY KEY (id)
);