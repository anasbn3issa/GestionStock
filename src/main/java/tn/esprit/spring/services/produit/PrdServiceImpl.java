package tn.esprit.spring.services.produit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Facture;
import tn.esprit.spring.entities.Fournisseur;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Rayon;
import tn.esprit.spring.entities.Stock;
import tn.esprit.spring.repositories.ClientRepository;
import tn.esprit.spring.repositories.FournisseurRepository;
import tn.esprit.spring.repositories.ProduitRepository;
import tn.esprit.spring.repositories.StockRepository;
import tn.esprit.spring.services.detailProd.ProdDetServiceImpl;
import tn.esprit.spring.services.rayon.RynServiceImpl;
import tn.esprit.spring.services.stock.StkServiceImpl;
@Service
public class PrdServiceImpl implements ProduitServiceImpl{
	
	@Autowired
	private ProduitRepository produitRepository;
	
	@Autowired
	private RynServiceImpl rynServiceImpl;
	
	@Autowired
	private StkServiceImpl stkServiceImpl;
	
	@Autowired
	private ProdDetServiceImpl prodDetServiceImpl;

	@Autowired
	private StockRepository stockRepository;
	
	@Autowired
	private FournisseurRepository fournisseurRepository;
	
	@Override
	public List<Produit> retrieveAllProduits() {
		return (List<Produit>) produitRepository.findAll();
	}
	@Transactional
	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		p.setRayon(rynServiceImpl.retrieveRayon(idRayon));
		p.setStock(stkServiceImpl.retrieveStock(idStock));
		DetailProduit dp = p.getDetailProduit();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		try {
			dp.setDateCreation(formatter.parse(formatter.format(date)));
			dp.setDateDerniereModification(formatter.parse(formatter.format(date)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prodDetServiceImpl.addProdDetail(dp);
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return produitRepository.findById(id).orElse(null);

	}
	@Override
	public Produit updateProduit(Produit p) {
		
		DetailProduit dp = p.getDetailProduit();
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		try {
			dp.setDateCreation(formatter.parse(formatter.format(date)));
			dp.setDateDerniereModification(formatter.parse(formatter.format(date)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.setDetailProduit(dp);
		return produitRepository.save(p);
	}
	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Fournisseur f = new Fournisseur();
		Produit p = new Produit();
		f = fournisseurRepository.getById(fournisseurId);
		p = produitRepository.findById(produitId).orElse(null);
		p.getFournisseurs().add(f);
		produitRepository.save(p);

		
	}
	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p = new Produit();
		Stock s = new Stock();
		p = produitRepository.findById(idProduit).orElse(null);
		s = stockRepository.findById(idStock).orElse(null);
		//s.getProduits().add(p);
		p.setStock(s);

		produitRepository.save(p);
		//stockRepository.save(s);

		
	}
	@Override
	public float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate) {
		return produitRepository.getRevenuBrutProduit(idProduit, startDate, endDate);
	}

}