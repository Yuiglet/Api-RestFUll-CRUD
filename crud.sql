PGDMP         :                {            crud    15.3    15.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16904    crud    DATABASE     x   CREATE DATABASE crud WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Mexico.1252';
    DROP DATABASE crud;
                postgres    false            �            1259    16906    tareas    TABLE     �   CREATE TABLE public.tareas (
    id bigint NOT NULL,
    descripcion_tarea character varying(255),
    estado_tarea character varying(255),
    nom_tarea character varying(255)
);
    DROP TABLE public.tareas;
       public         heap    postgres    false            �            1259    16905    tareas_id_seq    SEQUENCE     v   CREATE SEQUENCE public.tareas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.tareas_id_seq;
       public          postgres    false    215            �           0    0    tareas_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.tareas_id_seq OWNED BY public.tareas.id;
          public          postgres    false    214            e           2604    16909 	   tareas id    DEFAULT     f   ALTER TABLE ONLY public.tareas ALTER COLUMN id SET DEFAULT nextval('public.tareas_id_seq'::regclass);
 8   ALTER TABLE public.tareas ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            �          0    16906    tareas 
   TABLE DATA                 public          postgres    false    215   5
       �           0    0    tareas_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.tareas_id_seq', 2, true);
          public          postgres    false    214            g           2606    16913    tareas tareas_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.tareas
    ADD CONSTRAINT tareas_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.tareas DROP CONSTRAINT tareas_pkey;
       public            postgres    false    215            �   �   x�=��
�0D���٥� �vUj��T�í�$z�f�����Ü���&t�t�Oׅ�fU�������Q�_�\��U�k��X�\�vD��M&�Q{
ـv�[�ב�h�y/��@�z(��_���E��m4Q     