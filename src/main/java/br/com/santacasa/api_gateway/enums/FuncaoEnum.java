package br.com.santacasa.api_gateway.enums;

public enum FuncaoEnum {
        ADMIN(1L,"adm"),
        BASICO(2L,"basico");

        private Long funcaoId;
        private String nome;

        FuncaoEnum(Long id,String nome){
            this.funcaoId = funcaoId;
            this.nome = nome;
        }

        public Long getFuncaoId(){
            return funcaoId;
        }

        public String getNomeFuncao(){
            return this.nome;
        }

        public void setNomeFuncao(String nomeFuncao){
            this.nome = nomeFuncao;
        }
        public static FuncaoEnum getById(Long id){
            for(FuncaoEnum value : FuncaoEnum.values()){
                if (value.funcaoId.equals(id)){
                    return value;
                }
            }
            throw new IllegalArgumentException("ID inválido "+ id);
        }

}
