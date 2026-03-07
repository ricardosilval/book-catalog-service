-- public.books definition

-- Drop table

-- DROP TABLE public.books;

CREATE TABLE public.books (
	id uuid NOT NULL,
	author varchar(255) NOT NULL,
	isbn varchar(255) NULL,
	published_date date NULL,
	status varchar(255) NULL,
	title varchar(255) NOT NULL,
	CONSTRAINT books_pkey PRIMARY KEY (id),
	CONSTRAINT books_status_check CHECK (((status)::text = ANY ((ARRAY['AVAILABLE'::character varying, 'UNAVAILABLE'::character varying])::text[]))),
	CONSTRAINT uk_kibbepcitr0a3cpk3rfr7nihn UNIQUE (isbn)
);
